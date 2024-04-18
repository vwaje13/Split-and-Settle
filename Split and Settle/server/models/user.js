const mongoose = require("mongoose");

const userSchema = new mongoose.Schema({
  username: {
    type: String,
    unique: true,
    lowercase: true,
    required: true,
  },
  firstName: {
    type: String,
    max: [30, "First name must have fewer than 30 characters."],
    required: true,
  },
  lastName: {
    type: String,
    max: [30, "Last name must have fewer than 30 characters."],
    required: true,
  },
  password: {
    type: String,
    validate: {
      validator: function(value) {
        return /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(value); 
        // ^(?=.*[A-Z]): Requires at least one uppercase letter.
        // (?=.*\d): Requires at least one digit (number).
        // (?=.*[@$!%*?&]): Requires at least one special character among @$!%*?&.
        // [A-Za-z\d@$!%*?&]{8,}$: Ensures the length of the password is at least 8 characters.
      },
      message: "Passwords must include a capital letter, number, and special character and be 8 characters long",
    },
    //required: true,
  },
  creationDatetime: {
    type: Date,
    default: Date.now,
  },
});

module.exports = mongoose.model("user", userSchema);
