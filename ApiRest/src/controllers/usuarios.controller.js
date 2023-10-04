import * as usuariosServices from '../services/usuarios.service.js';

export const getUsuarios = (req, res) => {
    usuariosServices.getUsuarios()
        .then((result) => {
            res.status(200).json({
                data : result[0]
            });
        })
        .catch((err) => {
            res.status(500).send(err);
        });
};

export const getUsuario = (req, res) => {
    const {correo} = req.params;
    usuariosServices.getUsuario(correo)
        .then((result) => {
            res.status(200).json({
                data : result[0]
            });
        })
        .catch((err) => {
            res.status(500).send(err);
        });
};

export const createUsuario = (req, res) => {
    const usuario = req.body;
    usuariosServices.createUsuario(usuario)
        .then(() => {
            res.status(200).json({
                data : usuario
            });
        })
        .catch((err) => {
            res.status(500).send(err);
        });
};

export const updateUsuario = (req, res) => {
    const usuario = req.body;
    const {correo} = req.params;
    usuariosServices.updateUsuario(correo, usuario)
        .then(() => {
            res.status(200).json({
                data : usuario
            });
        })
        .catch((err) => {
            res.status(500).send(err);
        });
};

export const deleteUsuario = (req, res) => {
    const {correo} = req.params;
    usuariosServices.deleteUsuario(correo)
        .then((result) => {
            res.status(200).json({
                mensaje : `Usuario con correo ${correo} borrado exitosamente`
            });
        })
        .catch((err) => {
            res.status(500).send(err);
        });
};