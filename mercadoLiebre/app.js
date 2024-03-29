const express = require('express')
const path = require('path')

const app = express()

const publicPath = path.join(__dirname, '/public')
app.use(express.static(publicPath))

app.get('/', (req, res)=>{
    let homePath = path.join(__dirname, 'views', 'home.html')
    res.sendFile(homePath)
})

app.get('/login', (req, res)=>{
    let homePath = path.join(__dirname, 'views', 'login.html')
    res.sendFile(homePath)
})

app.get('/register', (req, res)=>{
    let homePath = path.join(__dirname, 'views', 'register.html')
    res.sendFile(homePath)
})

const port = process.env.PORT ||3030
app.listen(port, ()=>{
    console.log(`El servidor esta corriendo en http://localhost:${port} 🚀🚀🚀`);
   
})