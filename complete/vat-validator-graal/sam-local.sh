#!/bin/sh
docker build . -t vat-validator-graal
mkdir -p build
docker run --rm --entrypoint cat vat-validator-graal  /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000

