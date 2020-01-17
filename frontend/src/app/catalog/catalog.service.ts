import { Injectable } from '@angular/core';
import {MyCourse} from "../shared/mycourse/mycourse";

@Injectable({
  providedIn: 'root'
})
export class CatalogService {
words:[];
  constructor() { }

  public searchCourses(keywords : string): String[]{
  //  return this.words.includes(keywords);
    return this.words;
  }
}
