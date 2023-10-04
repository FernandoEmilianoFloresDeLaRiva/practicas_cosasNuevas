import mysql from 'mysql2';
import dotenv from 'dotenv';

//Para usar variables de entorno
dotenv.config();

const db = mysql.createConnection({
    host: process.env.HOST,
    user: process.env.USER,
    password: process.env.PASSWORD,
    database: process.env.DATABASE,
});

export default db.promise();