import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './components/App'
import MenuApp from './components/MenuApp'
import NotFound from './components/NotFound'

import Breeds from './containers/breed/'
import BreedForm from './containers/breed/BreedForm'

export default (
  <Route path='/' component={App} >
    <IndexRoute component={MenuApp} />
    <Route path='breeds' component={Breeds}>
      <Route path='new' component={BreedForm}/>
      <Route path='edit/:id' component={BreedForm}/>
    </Route>
    <Route path="*" component={NotFound}/>
  </Route>
)
