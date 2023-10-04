import React, { useReducer, useRef } from "react";
import "./App.css";

function App() {
  const nameTask = useRef();
  const [tasks, dispatch] = useReducer(reducerTasks, []);
  function reducerTasks(state, action) {
    switch (action.type) {
      case "addTask":
        return [...state, action.content];
      case "deleteTask": {
        return state.filter((task, index) => index !== action.indexDelete);
      }
      default: {
        return state;
      }
    }
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch({
      type: "addTask",
      content: nameTask.current.value,
    });
  };

  return (
    <div>
      <h1>Task List</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="taskName">Task Name:</label>
        <input id="taskName" ref={nameTask} />
      </form>
      <div className="tasks">
        {tasks &&
          tasks.map((task, index) => (
            <div key={index} className="task">
              <p>{task}</p>
              <button
                onClick={() =>
                  dispatch({ type: "deleteTask", indexDelete: index })
                }
              >
                Delete Task
              </button>
            </div>
          ))}
      </div>
    </div>
  );
}

export default App;
