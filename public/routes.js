import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './components/App'
import MenuApp from './components/MenuApp'
import Breeds from './containers/breed/Breeds'
import NewBreed from './containers/breed/NewBreed'

export default (
  <Route path='/' component={App} >
    <IndexRoute component={MenuApp} />
    <Route path='breeds' component={Breeds} />
    <Route path='breeds/new' component={NewBreed} />
  </Route>
)
