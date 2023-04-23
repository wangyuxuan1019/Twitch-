import { Layout, Row, Col, Button } from "antd";
import Login from "./Login";
import Register from "./Register";
import Favorites from "./Favorites";
// import { Header } from "antd/lib/layout/layout";

const { Header } = Layout;

function PageHeader({
  loggedIn,
  signinOnSuccess,
  signoutOnClick,
  favoriteItems,
}) {
  return (
    <Header>
      <Row justify="space-between">
        <Col>{loggedIn && <Favorites favoriteItems={favoriteItems} />}</Col>
        <Col>
          {loggedIn && (
            <Button shape="round" onClick={signoutOnClick}>
              logout
            </Button>
          )}
          {!loggedIn && (
            <>
              <Login onSuccess={signinOnSuccess} />
              <Register />
            </>
          )}
        </Col>
      </Row>
    </Header>
  );
}

export default PageHeader;
