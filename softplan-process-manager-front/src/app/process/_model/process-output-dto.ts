export class ProcessOutputDto {
  id: number;
  name: string;
  description: string;
  insertDate: any;
  updateDate: any;

  constructor() {
    this.name = null;
    this.description = null;
    this.insertDate = null;
    this.updateDate = null;
  }
}
