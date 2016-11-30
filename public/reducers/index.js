import { combineReducers } from 'redux'

import BreedsReducer from './reducerBreed'
import EspecieReducer from './reducerEspecie'
import AnimalsReducer from './reducerAnimals'

import CustomerReducer from './reducerCustomer'

import ModalReducer from './reducerModal'

import { reducer as formReducer } from 'redux-form'

const rootReducer = combineReducers({
  breedState : BreedsReducer,
  especieState : EspecieReducer,
  animalsState : AnimalsReducer,
  customerState : CustomerReducer,
  form : formReducer,
  modal : ModalReducer,
})

export default rootReducer
