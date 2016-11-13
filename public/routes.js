import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './components/App'
import MenuApp from './components/MenuApp'
import Breeds from './containers/breed/Breeds' 

export default (
  <Route path='/' component={App} >
    <IndexRoute component={MenuApp} />
    <Route path='breeds' component={Breeds} />
  </Route>
)
