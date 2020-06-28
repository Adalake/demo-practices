var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function(req, res){
  res.send('<h1>你好web秀</h1>');
});
 
io.on('connection',function(socket) {
  //接收数据
  socket.on('login', function (obj) {                
      console.log(obj.username,obj);
      // 发送数据
      socket.emit('relogin', {
        msg: `你好${obj.username}`,
        code: 200
      });  
  });
});
 
http.listen(3000, function(){
  console.log('listening on *:3000');
});
