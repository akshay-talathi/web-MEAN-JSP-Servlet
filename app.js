var express = require('express');
var path = require('path');
var favicon = require('serve-favicon'); //required dependencies
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var routes = require('./routes/index'); //routes required, going to pass module.exports from this file
//var users = require('./routes/users');
var products = require('./routes/products');

var app = express();  //app created by running express

// view engine setup
app.set('views', path.join(__dirname, 'views')); //default  view set in views directory
app.set('view engine', 'hjs'); // view engine set to use hjs
mongoose.connect('mongodb://localhost:27017/products')

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(require('less-middleware')(path.join(__dirname, 'public')));
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', routes);   //use routes here so that they come to know how to get used
//app.use('/users', users);
app.use('/products', products);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
    app.use(function(err, req, res, next)
     {

        res.status(err.status || 500);
        res.render('error', {
            message: err.message,
            error: err
        });
    });
}


// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
        message: err.message,
        error: {}
    });
});


module.exports = app;
