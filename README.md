# Aplicativo qualidade-ar

### Build da imagem

```shell
docker build -t projetosfiap.azurecr.io/qualidade-ar:latest .
```

### Execução local da imagem
```shell
docker run -it --name qualidade-ar -p 8080:8080 \
      -e DB_HOST=jdbc:oracle:thin:@//oracle.fiap.com.br:1521/ORCL \ 
      -e DB_USER=RM97963 -e DB_PASS=0000 projetosfiap.azurecr.io/qualidade-ar:latest
```
