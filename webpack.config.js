var app = {
  entry: [
    './public/index.js'
  ],
  output: {
    path: './src/main/webapp/',
    filename: 'bundle.js'
  },
  module: {
    loaders: [{
      exclude: /node_modules/,
      loader: 'babel',
      query: {
        presets: ['react', 'es2015', 'stage-1']
      }
    }]
  },
  resolve: {
    extensions: ['', '.js', '.jsx']
  },
  devServer: {
    historyApiFallback: true,
    contentBase: './src/main/webapp/'
  }
};

module.exports = app;
