import React, { useState, useEffect } from "react";

const Child = (props) => {
  const { parentBalance } = props;
  const [balance, setBalance] = useState(0);
  //const [balance, setBalance] = useState(props.parentBalance);

  // Similar to componentDidMount and componentDidUpdate
  useEffect(() => {
    console.log("componentDidMount/ componentDidUpdate - Child Component");
    // Return is Optional. Similar to componentWillUnmount
    // Clean up function
    return () => {
      //return fisrt before update -> re-render -> take effect
      console.log("componentWIllUnmount - Child Component");
    };
  });

  //console.log("render - Child Component");
  return (
    <div>
      <p>This is Child Component</p>
      <p>Parent balance: {parentBalance}</p>
      <p>My Balance: {balance}</p>
      <div>
        <button
          onClick={() => {
            setBalance(balance + 10);
          }}
        >
          Earn $10
        </button>
      </div>
    </div>
  );
};

export default Child;
