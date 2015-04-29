var express = require('express');  //required express
var router = express.Router();	   //created router file

/* GET home page. */
router.get('/', function(req, res) {
  //res.send('index', { title: 'Express' }); //change url here
  res.send({});
});

module.exports = router; //exported this file,return  value of whole file
