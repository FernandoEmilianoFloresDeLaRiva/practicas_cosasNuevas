import { Router } from "express";
import usuariosRouter from "./usuarios.route.js";

const indexRouter = Router();
const prefijo = '/api';

indexRouter.get(prefijo, (req, res) => {
    res.send('Bienvenido a mi API');
});

indexRouter.use(`${prefijo}/usuarios`, usuariosRouter);

export default indexRouter;