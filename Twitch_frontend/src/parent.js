import React, { useState, useEffect } from "react";
import Child from "./child";

const Parent = () => {
  const [showChild, setShowChild] = useState(false);
  const [balance, setBalance] = useState(100);

  // Similar to componentDidMount and componentDidUpdate
  useEffect(() => {
    console.log("componentDidMount/ componentDidUpdate - Parent Component");
    // Return is Optional. Similar to componentWillUnmount
    // Clean up function
    return () => {
      console.log("componentWIllUnmount - Parent Component");
    };
  });

  //console.log("render - Parent Component");
  return (
    <div>
      <h3>Function Component</h3>
      <p>This is a Parent component</p>
      <p>Balance: {balance}</p>
      <div>
        <button
          onClick={() => {
            setShowChild(!showChild);
          }}
        >
          Show/ Hide Child
        </button>
      </div>
      <br />
      <div>
        <button
          onClick={() => {
            setBalance(balance + 10);
          }}
        >
          Earn $10
        </button>
      </div>
      <hr />
      {showChild ? <Child parentBalance={balance} /> : null}
    </div>
  );
};

export default Parent;
