'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function (inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function () {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the triplets function below.
function triplets(t, d) {
    let attempts = 0;
    let sizeArray = d.length;
    d.order((a, b) => a - b);
    for (let i = 0; i < sizeArray - 2; i++) {
        for (let j = i + 1; j < sizeArray - 1; j++) {
            for (let k = j + 1; k < sizeArray; k++)
                if (d[i] < d[j] < d[k] && d[i] + d[j] + d[k] <= t)
                    attempts++;
        }
    }
    return attempts;
}

function main() {
    const t = parseInt(readLine().trim(), 10);

    const dCount = parseInt(readLine().trim(), 10);

    let d = [];

    for (let i = 0; i < dCount; i++) {
        const dItem = parseInt(readLine().trim(), 10);
        d.push(dItem);
    }

    const res = triplets(t, d);

    console.log(res)
}
