const express = require('express')
const routes = express.Router()

routes.get('/', (req, res) => {
    req.getConnection((err, conn) => {
        //Si exite un error lo muestra y no se hace lo demas
        if (err) return res.send(err)
        conn.query('select * from datosenfermera', (err, rows) => {
            //Si exite un error lo muestra y no se hace lo demas, caso contrario muestra las filas
            if (err) return res.send(err)
            res.json(rows)
        })
    })
})

routes.post('/' , (req, res) => {
    req.getConnection((err, conn) => {
        if (err) return res.send(err)
        console.log(req.body)
        conn.query('insert into datosenfermera set ?', [req.body], (err, rows) => {
            if(err) return res.send(err)
            res.send('Datos agregados exitosamente')
        })
    })
})

routes.delete('/:correo', (req, res) => {
    req.getConnection((err, conn) => {
        if (err) return res.send(err)
        conn.query('delete from datosenfermera where correo = ?', [req.params.correo], (err, rows) => {
            if (err) return res.send(err)
            res.send('Usuario eliminado')
        })
    })
})

routes.put('/:correo' , (req, res) => {
    req.getConnection((err, conn) => {
        if (err) return res.send(err)
        console.log(req.body)
        conn.query('update datosenfermera set ? where correo = ?', [req.body, req.params.correo], (err, rows) => {
            if(err) return res.send(err)
            res.send('Datos actualizado exitosamente')
        })
    })
})

module.exports = routes