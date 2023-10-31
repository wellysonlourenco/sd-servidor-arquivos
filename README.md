# TRABALHO 2 – SISTEMAS DISTRIBUÍDOS TSI 3713
<p><img src="https://i.ibb.co/3sNMDtV/Instituto-Federal-de-Mato-Grosso-do-Sul.png"  title="IFMS" width="160px"></img></p>

SERVIDOR DE ARQUIVOS - File Server</br>
Você deverá implementar um programa de servidor de rede. O programa é um 
servidor de arquivos simples que disponibiliza uma coleção de arquivos para 
transmissão aos clientes. Quando o servidor é inicializado, ele precisa saber o nome do 
diretório que contém a coleção de arquivos. Essa informação pode ser fornecida como 
um argumento de linha de comando. Você pode assumir que o diretório não contém 
subdiretórios e pode assumir que todos os arquivos são arquivos de texto.
Quando um cliente se conecta ao servidor, o servidor primeiro lê um comando 
do cliente. Os comandos que o servidor deve conhecer e responder são:
- INDEX: o servidor responde enviando uma lista de nomes de todos os 
arquivos que estão disponíveis no servidor. 
- GET <nome do arquivo>: onde <nome do arquivo> é um nome de arquivo. O servidor verifica se o arquivo solicitado realmente existe. Em caso afirmativo, ele 
primeiro envia a palavra "OK" como uma mensagem para o cliente. Em seguida, ele 
envia o conteúdo do arquivo e fecha a conexão. Caso contrário, ele envia uma linha 
começando com a palavra "ERROR" para o cliente e fecha a conexão.

Seu programa deve usar uma sub-rotina (thread) para lidar com cada 
solicitação que o servidor recebe. Ele não deve parar após o tratamento de uma 
solicitação; ele deve permanecer aberto e continuar a aceitar novas solicitações.
Você também deverá implementar um programa cliente para esse servidor. 
Projete uma interface de usuário que permita ao usuário fazer pelo menos duas coisas: 
- 1 Obter uma lista de arquivos que estão disponíveis no servidor e exibir a lista 
na saída padrão;
- 2 Obter uma cópia de um arquivo especificado do servidor e salve-o em um 
arquivo local (no computador em que o cliente está sendo executado).
Não é necessária interface gráfica, contudo, caso tenha, contará como bônus.
O critério de avaliação será o seguinte:
- 1 pontos para a inicialização do servidor identificando corretamente o 
diretório;
- 2 pontos para a conexão do cliente com o servidor, reconhecimento dos 
comandos INDEX e GET e envio de mensagens de erro quando o protocolo não for 
seguido;
- 2 pontos para exibição no cliente da lista de arquivos no servidor após 
comando INDEX;
- 5 pontos para a transferência de arquivos entre servidor e cliente após 
comando GET <nome do arquivo>.





```

Importação projeto no Eclipse
----------------------------
--- Passo a passo de como realizar a importação do projeto no eclipse
https://www.youtube.com/watch?v=WjQpxCwKd0w


Vai pedir usuario e senha para importar!
Precisa gerar o token
Click on settings Settings->Developer settings->Personal access tokens-> Generate new token.
https://www.youtube.com/watch?v=H_uyu9pzUE0
 
