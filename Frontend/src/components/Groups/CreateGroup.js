import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const CreateGroup = ({ onCreate }) => {
    const [groupName, setGroupName] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // Call the onCreate function with the groupName as an argument
        onCreate(groupName);
        // Reset the form
        setGroupName('');
    };

    return (
        <Form onSubmit={handleSubmit}>
            <Form.Group controlId="groupName">
                <Form.Label>Group Name</Form.Label>
                <Form.Control
                    type="text"
                    placeholder="Enter group name"
                    value={groupName}
                    onChange={(e) => setGroupName(e.target.value)}
                />
            </Form.Group>
            <Button variant="primary" type="submit">
                Create Group
            </Button>
        </Form>
    );
};

export default CreateGroup;