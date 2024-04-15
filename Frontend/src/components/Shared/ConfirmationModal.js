import React from 'react';
import { Modal, Button } from 'react-bootstrap';

const ConfirmationModal = ({ show, onConfirm }) => {
    return (
        <Modal show={show} onHide={onConfirm}>
            <Modal.Header closeButton>
                <Modal.Title>Confirmation</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                Are you sure you want to proceed?
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={onConfirm}>
                    Confirm
                </Button>
                <Button variant="primary" onClick={onConfirm}>
                    Cancel
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default ConfirmationModal;