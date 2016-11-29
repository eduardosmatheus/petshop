import React from 'react';
import ReactDOM from 'react-dom';

import { configureStore } from './store/configureStore';
import { Root } from './containers/Root';
import routes from './routes'

import './styles/main.scss'

const store = configureStore();

ReactDOM.render(
  <Root store={store} routes={routes}/>,
  document.getElementById('container')
);
