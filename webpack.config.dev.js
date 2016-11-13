const path = require('path');
const webpack = require('webpack');

module.exports = {
  devtool: 'cheap-module-eval-source-map',
  entry: [
    'eventsource-polyfill', // necessary for hot reloading with IE
    'webpack-hot-middleware/client',
    './public/index'
  ],
  output: {
    path: '/',
    filename: 'bundle.js'
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin(),
    new webpack.DefinePlugin({
      'process.env.NODE_ENV': JSON.stringify('development')
    }),
  ],
  module: {
    loaders: [
      {
        test: /\.js?/,
        exclude: [/node_modules/, /styles/],
        loaders: ['babel?presets[]=react,presets[]=es2015,presets[]=stage-0'], 
        include: path.join(__dirname, 'public')
      },
      {
        test: /\.scss$/,
        loader: 'style!css!sass',
        include: path.join(__dirname, 'public/styles')
      }
    ]
  }
};
