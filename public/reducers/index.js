import { combineReducers } from 'redux'
import BreedsReducer from './reducerBreed'
import ChangeStateReducer from './reducerChangeState'

const rootReducer = combineReducers({
  breeds : BreedsReducer,
  changeState : ChangeStateReducer
})

export default rootReducer
