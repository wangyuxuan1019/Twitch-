import { Button, message, Form, Input, Modal } from "antd";
import React, { useState } from "react";
import { LockOutlined, UserOutlined } from "@ant-design/icons";
import { register } from "../utils";

function Register() {
  const [displayModal, setDisplayModal] = useState(false);

  const handleCancel = () => {
    setDisplayModal(false);
  };

  const signupOnClick = () => {
    setDisplayModal(true);
  };

  const onFinish = (data) => {
    register(data)
      .then(() => {
        setDisplayModal(false);
        message.success("Successfully signed up");
      })
      .catch((err) => {
        message.error(err.message);
      });
  };

  return (
    <>
      <Button shape="round" type="primary" onClick={signupOnClick}>
        Register
      </Button>
      <Modal
        title="Register"
        visible={displayModal}
        onCancel={handleCancel}
        footer={null}
        destroyOnClose={true}
      >
        <Form
          name="normal_register"
          initialvalues={{ remember: true }}
          onFinish={onFinish}
          preserve={false}
        >
          <Form.Item
            name="username"
            rule={[{ required: true, message: "Please input your Username!" }]}
          >
            <Input prefix={<UserOutlined />} placeholder="Username" />
          </Form.Item>
          <Form.Item
            name="password"
            rule={[{ required: true, message: "Please input your Password!" }]}
          >
            <Input prefix={<LockOutlined />} placeholder="Password" />
          </Form.Item>
          <Form.Item
            name="first_name"
            rule={[{ required: true, message: "Please input your Firstname!" }]}
          >
            <Input placeholder="Firstname" />
          </Form.Item>
          <Form.Item
            name="last_name"
            rule={[{ required: true, message: "Please input your Lastname!" }]}
          >
            <Input placeholder="Lastname" />
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit">
              Register
            </Button>
          </Form.Item>
        </Form>
      </Modal>
    </>
  );
}

export default Register;
