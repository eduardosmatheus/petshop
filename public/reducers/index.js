import { combineReducers } from 'redux'
import BreedsReducer from './reducerBreed'
import EspecieReducer from './reducerEspecie'
import AnimalsReducer from './reducerAnimals'
import ModalReducer from './reducerModal'

import { reducer as formReducer } from 'redux-form'

const rootReducer = combineReducers({
  breedState : BreedsReducer,
  animals : AnimalsReducer,
  form : formReducer,
  modal : ModalReducer,
  especieState : EspecieReducer
})

export default rootReducer
