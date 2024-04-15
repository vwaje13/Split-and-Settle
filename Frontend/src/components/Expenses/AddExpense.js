import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const AddExpense = ({ onAdd }) => {
    const [expense, setExpense] = useState({
        description: '',
        amount: 0,
        date: ''
    });

    const handleChange = (e) => {
        setExpense({
            ...expense,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onAdd(expense);
        setExpense({
            description: '',
            amount: 0,
            date: ''
        });
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="description">
                <Form.Label>Description</Form.Label>
                <Form.Control
                    type="text"
                    name="description"
                    value={expense.description}
                    onChange={handleChange}
                />
            </Form.Group>

            <Form.Group controlId="amount">
                <Form.Label>Amount</Form.Label>
                <Form.Control
                    type="number"
                    name="amount"
                    value={expense.amount}
                    onChange={handleChange}
                />
            </Form.Group>

            <Form.Group controlId="date">
                <Form.Label>Date</Form.Label>
                <Form.Control
                    type="date"
                    name="date"
                    value={expense.date}
                    onChange={handleChange}
                />
            </Form.Group>

            <Button variant="primary" type="submit">
                Add Expense
            </Button>
        </Form>
    );
};

export default AddExpense;