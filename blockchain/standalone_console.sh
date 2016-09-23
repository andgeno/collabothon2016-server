#!/bin/bash -e

NETWORKID=123
DATADIR=./private-chain-data-$NETWORKID

mkdir -p $DATADIR
cp ./static-nodes.json $DATADIR
./geth.exe --datadir $DATADIR init ./genesis-block.json
./geth.exe --datadir $DATADIR --nat none --networkid $NETWORKID --port $NETWORKID --rpc --rpcaddr 0.0.0.0 --etherbase 0x05213cdff76d244fcc970444a68d6b0f35b1eb21 --rpccorsdomain '*' --maxpeers 0 --nodiscover console
