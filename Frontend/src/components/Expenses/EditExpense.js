import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const EditExpense = ({ expense, onSave }) => {
    const [title, setTitle] = useState(expense.title);
    const [amount, setAmount] = useState(expense.amount);
    const [date, setDate] = useState(expense.date);

    const handleTitleChange = (e) => {
        setTitle(e.target.value);
    };

    const handleAmountChange = (e) => {
        setAmount(e.target.value);
    };

    const handleDateChange = (e) => {
        setDate(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const updatedExpense = {
            id: expense.id,
            title,
            amount,
            date,
        };
        onSave(updatedExpense);
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="title">
                <Form.Label>Title</Form.Label>
                <Form.Control
                    type="text"
                    value={title}
                    onChange={handleTitleChange}
                />
            </Form.Group>
            <Form.Group controlId="amount">
                <Form.Label>Amount</Form.Label>
                <Form.Control
                    type="number"
                    value={amount}
                    onChange={handleAmountChange}
                />
            </Form.Group>
            <Form.Group controlId="date">
                <Form.Label>Date</Form.Label>
                <Form.Control
                    type="date"
                    value={date}
                    onChange={handleDateChange}
                />
            </Form.Group>
            <Button variant="primary" type="submit">
                Save
            </Button>
        </Form>
    );
};

export default EditExpense;