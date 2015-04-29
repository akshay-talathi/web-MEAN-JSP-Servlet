var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');

mongoose.model('products', {});

/* GET users listing. */
router.get('/', function(req, res) {
  	mongoose.model('products').find(function(err, products){
  		res.json(products);
  	});
});

router.get('/:id', function(req, res) {
	var id = req.params.id;
  	mongoose.model('products').findOne({type: id}, function(err, product){
 		res.json(product);
  	});
 });

router.get('/cat/:name', function(req, res) {
	var name = req.params.name;
  	mongoose.model('products').find({Name: name}, function(err, product){
  		res.json(product);
  	});
});

router.get('/prods/all/cats', function(req,res){
	mongoose.model('products').find().distinct('Name', function(error, names)
	{
		res.json(names);
	})
});
module.exports = router;
