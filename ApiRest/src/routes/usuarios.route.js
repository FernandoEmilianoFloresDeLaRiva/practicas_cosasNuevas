import { Router } from "express";
import { getUsuarios, getUsuario, createUsuario, updateUsuario, deleteUsuario } from "../controllers/usuarios.controller.js";

const usuariosRouter = Router();

usuariosRouter.get('/', getUsuarios);

usuariosRouter.get('/:correo', getUsuario);

usuariosRouter.post('/', createUsuario);

usuariosRouter.put('/:correo', updateUsuario);

usuariosRouter.delete('/:correo', deleteUsuario);

export default usuariosRouter;