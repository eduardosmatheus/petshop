import { CLEAR_ACTUAL_ESPECIE, FETCH_ESPECIES, CREATE_ESPECIE,
  GET_ESPECIE, UPDATE_ESPECIE, DELETE_ESPECIE,
  ERROR } from '../actions'

const INITIAL_STATE = {
  all : [],
  actual : {
    id : '',
    description : ''
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_ESPECIES:
      return {...state, all : action.payload }
      break
    case CREATE_ESPECIE:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_ESPECIE:
      all = all.map((ob) => {
        if(ob.id === actual.id) {
          return action.payload
        }
        return ob
      })
      return {...state, all : all, actual : INITIAL_STATE.actual}
      break
    case DELETE_ESPECIE:
      let x = all.indexOf(action.payload)
      all.splice(x, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_ESPECIE:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_ESPECIE:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
