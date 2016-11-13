import React, { Component } from 'react';
import { Provider } from 'react-redux';
import { Router, browserHistory } from 'react-router'

export class Root extends Component {
  render() {
    const { store, routes } = this.props;
    return (
      <Provider store={store}>
        <Router history={browserHistory} routes={routes}/>
      </Provider>
    );
  }
}
