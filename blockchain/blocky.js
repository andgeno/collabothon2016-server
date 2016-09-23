    var Web3 = require('web3');
	web3 = new Web3(new Web3.providers.HttpProvider('http://localhost:8088'));
	var coinbase = web3.eth.coinbase;
	var id=0;
	console.log(coinbase);
    
	var express = require('express');
    var app = express();
	
	
	app.get('/pay/:addr', function (req, res) {
       id++;
	   var contractAddress= "0xfc7bc586b4f3e9c1dfcb4ebaf97dd397f5a2514b";
	   var singleperson = web3.eth.contract([{"constant":false,"inputs":[],"name":"pay","outputs":[],"payable":true,"type":"function"},{"constant":false,"inputs":[],"name":"kill","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"check","outputs":[{"name":"","type":"bool"}],"payable":false,"type":"function"},{"inputs":[],"type":"constructor"}]).at(contractAddress)
	   var addr = singleperson.pay.sendTransaction({from: web3.eth.accounts[0], value: web3.toWei(1, "ether")});

	   console.log(id +" "+ addr)
	   res.end(addr);
	})
	
	app.get('/check/:addr', function(req, res){
	   id++;
	   var contractAddress= "0xfc7bc586b4f3e9c1dfcb4ebaf97dd397f5a2514b";
	   var singleperson = web3.eth.contract([{"constant":false,"inputs":[],"name":"pay","outputs":[],"payable":true,"type":"function"},{"constant":false,"inputs":[],"name":"kill","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"check","outputs":[{"name":"","type":"bool"}],"payable":false,"type":"function"},{"inputs":[],"type":"constructor"}]).at(contractAddress)
	   var isDone = singleperson.check();

	   console.log(id +" "+ isDone)
	   res.type('json')
	   res.end(isDone.toString());
	});
	
	var server = app.listen(1337, function (){
		var host = server.address().address
		var port = server.address().port
	})

	/**var http = require('http');
    http.createServer(function (req, res) {
      res.writeHead(200, {'Content-Type': 'text/plain'});
	   
      res.end('Hello World\n');
    }).listen(1337, "127.0.0.1");
    
	console.log('Server running at http://127.0.0.1:1337/');
*/