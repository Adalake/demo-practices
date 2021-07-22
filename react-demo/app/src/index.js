// import React from 'react';
// import ReactDOM from 'react-dom';
// import './index.css';
// import App from './App';
// import reportWebVitals from './reportWebVitals';

// ReactDOM.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>,
//   document.getElementById('root')
// );
//  reportWebVitals();

import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
class Square extends React.Component {
  // 向这个 class 中添加一个构造函数，用来初始化 state
  constructor(props) {
    super(props);
    this.state = {
      value: null,
    };
  }
  render() {
    return (
      <button
        className="square"
        onClick={() => {
          this.setState({ value: "X" });
        }}
      >
        {/* {this.props.value} */}
        {this.state.value}
      </button>
    );
  }
}

class Board extends React.Component {
  // 传递一个名为 value 的 prop 到 Square 当中：
  renderSquare(i) {
    return <Square value={i} />;
  }

  render() {
    const status = "Next player: X";
    return (
      <div>
        <div className="status">{status}</div>
        <div className="board-row">
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
        </div>
        <div className="board-row">
          {this.renderSquare(3)}
          {this.renderSquare(4)}
          {this.renderSquare(5)}
        </div>
        <div className="board-row">
          {this.renderSquare(6)}
          {this.renderSquare(7)}
          {this.renderSquare(8)}
        </div>
      </div>
    );
  }
}

class Game extends React.Component {
  render() {
    return (
      <div className="game">
        <div className="game-board">
          <Board />
        </div>
        <div className="game-info">
          <div>{/* status */}</div>
          <ol>{/* TODO */}</ol>
        </div>
      </div>
    );
  }
}

ReactDOM.render(<Game />, document.getElementById("root"));
