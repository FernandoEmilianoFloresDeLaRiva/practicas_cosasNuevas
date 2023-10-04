const express = require("express");
const mysql = require("mysql2");
const myconn = require("express-myconnection");
const routes = require("./routes");

const db = {
  host: process.env.HOST,
  user: process.env.USER,
  password: process.env.PASSWORD,
  database: process.env.DATABASE,
  port: 3306,
};

const app = express();
app.set("port", process.env.PORT || 9000);

//middlware
app.use(myconn(mysql, db, "single"));
app.use(express.json());

//routes
app.get("/", (req, res) => {
  res.send("Bienvenido a la API :)");
});
app.use("/api", routes);

//Verificacion que el servidor esta corriendo
app.listen(9000, () => {
  console.log("Servidor corriendo en puerto ", app.get("port"));
});
