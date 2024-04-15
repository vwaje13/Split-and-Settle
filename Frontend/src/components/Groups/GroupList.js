import React from 'react';
import { ListGroup } from 'react-bootstrap';

const GroupList = ({ groups }) => {
    return (
        <ListGroup>
            {groups.map((group) => (
                <ListGroup.Item key={group.id}>{group.name}</ListGroup.Item>
            ))}
        </ListGroup>
    );
};

export default GroupList;