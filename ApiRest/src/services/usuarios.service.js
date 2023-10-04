import db from "../config/db.js";

export const getUsuarios = () => {
    return new Promise((resolve, reject) => {
        const query = 'select * from datosenfermera';
        db.execute(query)
            .then((result) => {
                resolve(result);
            })
            .catch((err) => {
                reject(err);
            });
    });
};

export const getUsuario = (correo) => {
    return new Promise((resolve, reject) => {
        const query = 'select * from datosenfermera where correo = ?';
        db.execute(query, [correo])
            .then((result) => {
                resolve(result);
            })
            .catch((err) => {
                reject(err);
            });
    });
};

export const createUsuario = (usuario) => {
    return new Promise((resolve, reject) => {
        const query = 'insert into datosenfermera (correo, clave) values (?, ?)';
        const {correo, clave} = usuario;
        db.execute(query, [correo, clave])
            .then((result) => {
                resolve(result);
            })
            .catch((err) => {
                reject(err);
            });
    });
};

export const updateUsuario = (correoId, usuario) => {
    return new Promise((resolve, reject) => {
        const query = 'update datosenfermera set correo = ?, clave = ? where correo = ?';
        const {correo, clave} = usuario;
        db.execute(query, [correo, clave, correoId])
            .then((result) => {
                resolve(result);
            })
            .catch((err) => {
                reject(err);
            });
    });
};

export const deleteUsuario = (correo) => {
    return new Promise((resolve, reject) => {
        const query = 'delete from datosenfermera where correo = ?';
        db.execute(query, [correo])
            .then((result) => {
                resolve(result);
            })
            .catch((err) => {
                reject(err);
            });
    });
};