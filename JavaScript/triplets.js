'use strict';
const assert = require('assert');

function triplets(t, d) {
    let attempts = 0;
    let sizeArray = d.length;
    // d.sort((a, b) => a - b);
    for (let i = 0; i < sizeArray - 2; i++) {
        for (let j = i + 1; j < sizeArray - 1; j++) {
            for (let k = j + 1; k < sizeArray; k++) {
                // console.log(`(${d[i]}, ${d[j]}, ${d[k]})`);
                if (d[i] < d[j] < d[k] && d[i] + d[j] + d[k] <= t)
                    attempts++;
            }
        }
    }
    return attempts;
}

function test(sum, array, expected) {
    console.log('-------------------------------------');
    console.log('IN', sum, '->', array);
    const label = 'Total time';
    console.time(label);
    const result = triplets(sum, array);
    console.timeEnd(label);
    console.log('\nOUT', result);
    assert.equal(result, expected);
    console.log('-------------------------------------');
}

test(8, [1, 2, 3, 4, 6], 3);
test(500, Array.from({ length: 2000 }, (_, i) => i + 1), 3420347);

console.log('Tests Success!');
