const path = require('path');

module.exports = {
    entry:'./src/index.js',
    output:{
        filename: 'dist.js',
        path: path.resolve(__dirname, 'dist')
    },

    module:{
        rules:[{
            test:/\.css$/,
            use:"style-loader!css-loader"
        }]
    },

    module: {
        rules: [{
            test: require.resolve("jquery"),
            use: [{
                loader:"expose-loader",
                options:"$"
            }]
        }]
    }
}