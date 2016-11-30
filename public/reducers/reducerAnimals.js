import { CLEAR_ACTUAL_ANIMAL, FETCH_ANIMALS, CREATE_ANIMAL,
  GET_ANIMAL, UPDATE_ANIMAL, DELETE_ANIMAL,
  ERROR } from '../actions'

const INITIAL_STATE = {
  all: [],
  actual: {
    id: '',
    name: '',
    obs: '',
    especie: {
      id: '',
      name: ''
    },
    breed: {
      id: '',
      name:  ''
    },
    customer : {
      id : '',
      name : '',
      cpf : '',
      phone : '',
      email : ''
    }
  },
  error : null
}

export default function(state = INITIAL_STATE, action) {
  let {all, actual} = state
  switch (action.type) {
    case FETCH_ANIMALS:
      return {...state, all : action.payload }
      break
    case CREATE_ANIMAL:
      all.push(action.payload)
      return {...state, all : state.all}
      break
    case UPDATE_ANIMAL:
      all = all.map((ob) => {
        if(ob.id === actual.id) {
          return action.payload
        }
        return ob
      })
      return {...state, all : all, actual : INITIAL_STATE.actual}
      break
    case DELETE_ANIMAL:
      let x = all.indexOf(action.payload)
      all.splice(x, 1)
      return {...state, all : state.all, actual : INITIAL_STATE.actual}
      break
    case GET_ANIMAL:
      return {...state, actual : action.payload }
      break
    case CLEAR_ACTUAL_ANIMAL:
      return {...state, actual : INITIAL_STATE.actual}
      break
    case ERROR :
      return {...state, error : action.error}
      break
  }

  return state;
}
