import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './components/App'
import MenuApp from './components/MenuApp'
import NotFound from './components/NotFound'

import Animals from './containers/animals'
import Customers from './containers/customers'
import Breeds from './containers/animals/breed/'
import Especies from './containers/animals/especies/'

export default (
  <Route path='/' component={App} >
    <IndexRoute component={MenuApp} />
    <Route path='customers' component={Customers} />
    <Route path='animals' component={Animals} >
      <Route path='breeds' component={Breeds} />
      <Route path='especies' component={Especies} />
    </Route>
    <Route path="*" component={NotFound}/>
  </Route>
)
