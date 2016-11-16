import React from 'react'
import { Route, IndexRoute } from 'react-router'

import App from './components/App'
import MenuApp from './components/MenuApp'
import NotFound from './components/NotFound'

import Animals from './containers/animals'

import Breeds from './containers/animals/breed/'
import BreedForm from './containers/animals/breed/BreedForm'

export default (
  <Route path='/' component={App} >
    <IndexRoute component={MenuApp} />
    <Route path='animals' component={Animals} >
      <Route path='breeds' component={Breeds}>
        <Route path='new' component={BreedForm}/>
        <Route path='edit/:id' component={BreedForm}/>
      </Route>
    </Route>
    <Route path="*" component={NotFound}/>
  </Route>
)
