import { combineReducers } from 'redux'
import BreedsReducer from './reducerBreed'
import AnimalsReducer from './reducerAnimals'
import ModalReducer from './reducerModal'

import { reducer as formReducer } from 'redux-form'

const rootReducer = combineReducers({
  breedState : BreedsReducer,
  animals : AnimalsReducer,
  form : formReducer,
  modal : ModalReducer
})

export default rootReducer
