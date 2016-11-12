import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './components/app'
import Breeds from './containers/breeds'

export default (
  <Route path='/' component={App} >
    <Route path='breeds' component={Breeds} />
  </Route>
)
